/*******************************************************************
 * See the NOTICE file distributed with this work for additional   *
 * information regarding Copyright ownership.  The author/authors  *
 * license this file to you under the terms of the Apache License, *
 * Version 2.0 (the "License"); you may not use this file except   *
 * in compliance with the License.  You may obtain a copy of the   *
 * License at:                                                     *
 *                                                                 *
 *     http://www.apache.org/licenses/LICENSE-2.0                  *
 *                                                                 *
 * Unless required by applicable law or agreed to in writing,      *
 * software distributed under the License is distributed on an     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY          *
 * KIND, either express or implied.  See the License for the       *
 * specific language governing permissions and limitations         *
 * under the License.                                              *
 *******************************************************************/

package codes.reactive.scalatime.test

import org.scalatest.{Matchers, FeatureSpec}


class ScalaTimeSuite extends FeatureSpec with Matchers {

  info("Scala Time allows use with only core implicit conversions in scope")

  feature("'simple' usage via import of 'ke.co.sbsproperties.scalatime._'") {
    import codes.reactive.scalatime._

    val period: Period = Period.days(1)

    val duration = Duration.days(1)

    duration shouldBe java.time.Duration.ofDays(1)

    period shouldBe  java.time.Period.ofDays(1)
  }

  feature("'extended' usage with additional implicits import of 'conversions._'") {
    import codes.reactive.scalatime._
    import dsl._

    val duration: Duration = 1L day

    val otherDuration: Duration = 2L days

    val period = 1 day
    val otherPeriod = 2 days

    duration + otherDuration shouldBe java.time.Duration.ofDays(3)
    period + otherPeriod shouldBe java.time.Period.ofDays(3)
  }

}