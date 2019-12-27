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

import org.scalatest._

class Day2Spec extends FlatSpec {

  "A computer" should "accurately run intcode programs" in {
    assert(Computer.runIntcodeProgram(List(1,0,0,0,99)) == List(2,0,0,0,99))
    assert(Computer.runIntcodeProgram(List(2,3,0,3,99)) == List(2,3,0,6,99))
    assert(Computer.runIntcodeProgram(List(2,4,4,5,99,0)) == List(2,4,4,5,99,9801))
    assert(Computer.runIntcodeProgram(List(1,1,1,4,99,5,6,0,99)) == List(30,1,1,4,2,5,6,0,99))
  }

  it should "accurately restore 1202 program alarm" in {
    assert(Computer.resetProgram(Computer.getIntcodeProgram(), 12, 2) == List(3562672, 12, 2, 2, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 9, 36, 1, 5, 19, 37, 1, 6, 23, 39, 1, 27, 10, 43, 1, 31, 5, 44, 2, 10, 35, 176, 1, 9, 39, 179, 1, 43, 5, 180, 1, 47, 6, 182, 2, 51, 6, 364, 1, 13, 55, 369, 2, 6, 59, 738, 1, 63, 5, 739, 2, 10, 67, 2956, 1, 9, 71, 2959, 1, 75, 13, 2964, 1, 10, 79, 2968, 2, 83, 13, 14840, 1, 87, 6, 14842, 1, 5, 91, 14843, 2, 95, 9, 44529, 1, 5, 99, 44530, 1, 103, 6, 44532, 2, 107, 13, 222660, 1, 111, 10, 222664, 2, 10, 115, 890656, 1, 9, 119, 890659, 1, 123, 9, 890662, 1, 13, 127, 890667, 2, 10, 131, 3562668, 1, 135, 5, 3562669, 1, 2, 139, 3562671, 1, 143, 5, 0, 99, 2, 0, 14, 0))
  }

  it should "accurately find the verb and nouns required for a specific output" in {
    assert(Computer.debugProgram(Computer.getIntcodeProgram(), 19690720) == List(19690720, 82, 50, 2, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 9, 246, 1, 5, 19, 247, 1, 6, 23, 249, 1, 27, 10, 253, 1, 31, 5, 254, 2, 10, 35, 1016, 1, 9, 39, 1019, 1, 43, 5, 1020, 1, 47, 6, 1022, 2, 51, 6, 2044, 1, 13, 55, 2049, 2, 6, 59, 4098, 1, 63, 5, 4099, 2, 10, 67, 16396, 1, 9, 71, 16399, 1, 75, 13, 16404, 1, 10, 79, 16408, 2, 83, 13, 82040, 1, 87, 6, 82042, 1, 5, 91, 82043, 2, 95, 9, 246129, 1, 5, 99, 246130, 1, 103, 6, 246132, 2, 107, 13, 1230660, 1, 111, 10, 1230664, 2, 10, 115, 4922656, 1, 9, 119, 4922659, 1, 123, 9, 4922662, 1, 13, 127, 4922667, 2, 10, 131, 19690668, 1, 135, 5, 19690669, 1, 2, 139, 19690719, 1, 143, 5, 0, 99, 2, 0, 14, 0))
  }

}
