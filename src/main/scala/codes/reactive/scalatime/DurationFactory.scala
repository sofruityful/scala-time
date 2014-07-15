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

package codes.reactive.scalatime

import scala.util.Try


private[scalatime] abstract class DurationFactory {


  /** Tries to obtain an instance of [[Duration]] from a temporal amount which has an
    * exact duration.
    */
  def from(amount: TemporalAmount): Try[Duration]

  /** Tries to obtain an instance of [[Duration]] from a [[scala.Predef.String String]] based on
    * the ISO-8601 Duration format - PnDTnHnMn.nS - with days considered to be exactly 24 hours.
    *
    * ==== String Format ====
    * The string starts with an optional sign, denoted by the ASCII negative or positive symbol.
    * If negative, the whole period is negated.
    *
    * The ASCII letter "P" is next in upper or lower case.
    *
    * There are then four sections, each consisting of a number and a suffix. The sections have
    * suffixes in ASCII of "D", "H", "M" and "S" for days, hours, minutes and seconds, accepted in
    * upper or lower case.
    *
    * The suffixes must occur in order. The ASCII letter "T" must occur before the first
    * occurrence, if any, of an hour, minute or second section. At least one of the four
    * sections must be present, and if "T" is present there must be at least one section after the
    * "T". The number part of each section must consist of one or more ASCII digits. The number may
    * be prefixed by the ASCII negative or positive symbol. The number of days, hours and minutes must
    * parse to an long. The number of seconds must parse to an long with optional fraction. The decimal
    * point may be either a dot or a comma. The fractional part may have from zero to 9 digits.
    *
    * The leading plus/minus sign, and negative values for other units are not part of the
    * ISO-8601 standard.
    *
    * @example
    *          {{{
    *            import codes.reactive.scalatime._
    *
    *            // Parses as 20.345 seconds
    *            val dur1 = Duration.parse("PT20.345S")
    *
    *            // Parses as 2 days, 3 hours, 4 minutes
    *            val dur2 = Duration.parse("P2DT3H4M")
    *
    *            // Parses as minus 6 hours, 3 minutes
    *            val dur3 = Duration.parse("P-6H3M")
    *          }}}
    */
  def parse(text: String): Try[Duration]

  /** Returns a [[Duration]] instance representing a number of nanoseconds. */
  def nanos(nanos: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of milliseconds. */
  def millis(millis: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of seconds. */
  def seconds(seconds: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of minutes. */
  def minutes(minutes: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of hours. */
  def hours(hours: Long): Duration

  /** Returns a new [[Duration]] instance representing a number of days. */
  def days(days: Long): Duration

  /** Returns a [[Duration]] instance representing a duration of zero. */
  def Nil: Duration

}
