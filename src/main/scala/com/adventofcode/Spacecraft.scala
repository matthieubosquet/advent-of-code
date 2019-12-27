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

object Spacecraft extends App {

  def getFuelRequired(): Int =
    getModuleMassList().map(getFuelRequiredForModule(_)).sum

  def getFuelRequiredForMass(mass: Int): Int = mass / 3 - 2

  def getFuelRequiredForModule(mass: Int): Int =
    if (getFuelRequiredForMass(mass) > 0)
      getFuelRequiredForMass(mass) + getFuelRequiredForModule(getFuelRequiredForMass(mass))
    else 0

  def getModuleMassList(): List[Int] =
    Source.fromResource("day1-input.txt").getLines.toList.map(_.toInt)

}
