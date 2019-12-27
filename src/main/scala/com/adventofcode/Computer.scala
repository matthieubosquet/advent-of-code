// Copyright (C) 2019 Matthieu Bosquet.
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import scala.io.Source

object Computer {

  def getIntcodeProgram(): List[Int] =
    Source.fromResource("day2-input.txt").mkString.split(',').map(_.toInt).toList

  def debugProgram(program: List[Int], expectedOutput: Int): List[Int] = {
    for (noun <- 0 to 99) {
      for (verb <- 0 to 99) {
        if (resetProgram(program, noun, verb)(0) == expectedOutput) {
          return resetProgram(program, noun, verb)
        }
      }
    }
    throw new Exception
  }

  def resetProgram(program: List[Int], noun: Int, verb: Int): List[Int] = runIntcodeProgram(program.patch(1, Seq(noun), 1).patch(2, Seq(verb), 1), 0)

  def runInstruction(program: List[Int], position: Int = 0): List[Int] =
    if (program(position) == 1) program.patch(program(position+3), Seq(program(program(position+1)) + program(program(position+2))), 1)
    else if (program(position) == 2) program.patch(program(position+3), Seq(program(program(position+1)) * program(program(position+2))), 1)
    else throw new Exception

  def runIntcodeProgram(program: List[Int], position: Int = 0): List[Int] =
    if (program(position) == 99) program
    else runIntcodeProgram(runInstruction(program, position), position + 4)

}
