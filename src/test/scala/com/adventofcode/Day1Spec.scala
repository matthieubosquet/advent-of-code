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

class Day1Spec extends FlatSpec {

  "A spacecraft" should "accurately calculate fuel requirements for a given mass" in {
    assert(Spacecraft.getFuelRequiredForMass(12) == 2)
    assert(Spacecraft.getFuelRequiredForMass(14) == 2)
    assert(Spacecraft.getFuelRequiredForMass(1969) == 654)
    assert(Spacecraft.getFuelRequiredForMass(100756) == 33583)
  }

  it should "accurately calculate fuel requirements for a module" in {
    assert(Spacecraft.getFuelRequiredForModule(14) == 2)
    assert(Spacecraft.getFuelRequiredForModule(1969) == 966)
    assert(Spacecraft.getFuelRequiredForModule(100756) == 50346)
  }

  it should "accurately calculate its total fuel requirement" in {
    assert(Spacecraft.getFuelRequired() == 4989588)
  }

  // Accurate calculation for part one based on the wrong equation
  // it should "accurately calculate its total fuel requirement" in {
  //   assert(Spacecraft.getRequiredFuel() == 3328306)
  // }

}
