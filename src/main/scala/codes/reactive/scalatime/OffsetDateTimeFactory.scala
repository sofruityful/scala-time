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


private[scalatime] abstract class OffsetDateTimeFactory {


  /** Creates a new [[OffsetDateTime]] instance by querying the current system UTC clock
    * for the current date time.
    *
    * @return  a new [[OffsetDateTime]]
    */
  def apply(): OffsetDateTime

  /** Creates a new [[OffsetDateTime]] instance by querying the provided clock
    * for the current date time.
    *
    * @return  a new [[OffsetDateTime]]
    */
  def apply(clock: Clock): OffsetDateTime

  /** Queries a [[Temporal]] to obtain an [[OffsetDateTime]] (if available)
    *
    * @param from the temporal to query
    * @throws DateTimeException - if unable to convert to an [[OffsetDateTime]]
    * @return  a new [[OffsetDateTime]]
    */
  def from(from: TemporalAccessor): Try[OffsetDateTime]

  /** Obtains a [[OffsetDateTime]] instance from [[LocalDate]], [[LocalTime]] and [[ZoneOffset]] instances **/
  def apply(date: LocalDate, time: LocalTime, zone: ZoneOffset): OffsetDateTime

  /** Obtains a [[OffsetDateTime]] instance from a [[LocalDateTime]] and [[ZoneID]] instance **/
  def apply(dateTime: LocalDateTime, zone: ZoneOffset): OffsetDateTime

  /** Creates a new [[OffsetDateTime]] instance from a year, month, day, hour, minute, second, nanosecond and offset.
    * An exception will be thrown if the day is not valid for the year and month or if the value of any field is
    * out of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @param nano the nano to represent
    * @param zone the time zone
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    * @return  a new [[OffsetDateTime]]
    */
  def of(year: Int,
         month: Int,
         day: Int,
         hour: Int,
         minute: Int,
         second: Int,
         nano: Int,
         zone: ZoneOffset): OffsetDateTime


  /** Creates a new [[OffsetDateTime]] instance from a year, month, day, hour, minute, second, nanosecond and offset.
    * An exception will be thrown if the day is not valid for the year and month or if the value of any field is out
    * of range.
    *
    * @param year the year to represent
    * @param month the month to represent
    * @param day the day to represent
    * @param hour the hour to represent
    * @param minute the minute to represent
    * @param second the second to represent
    * @param nano the nano to represent
    * @param zone the time zone
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    * @return  a new [[OffsetDateTime]]
    */
  def of(year: Int,
         month: Month,
         day: Int,
         hour: Int,
         minute: Int,
         second: Int,
         nano: Int,
         zone: ZoneOffset): OffsetDateTime


  /** Tries to obtain an [[OffsetDateTime]] instance from text formatted according to
    * [[DateTimeFormatter.Iso.OffsetDateTime]].
    *
    * @param text the text to parse such as "2007-12-03T10:15:30+01:00"
    */
  def parse(text: String): Try[OffsetDateTime]

  /** Tries to obtain an [[OffsetDateTime]] instance from valid text formatted according to the provided `formatter`. */
  def parse(text: String, formatter: DateTimeFormatter): Try[OffsetDateTime]

  /** The maximum supported OffsetDateTime, '+999999999-12-31T23:59:59.999999999-18:00' - or 'far future'. **/
  def Max: OffsetDateTime

  /** The minimum supported OffsetDateTime, '-999999999-01-01T00:00:00+18:00' - or 'far past'. **/
  def Min: OffsetDateTime

}
