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

package codes.reactive.scalatime.format

import java.time.format.{DateTimeFormatter => DF}
import java.util.Locale

import codes.reactive.scalatime._


/** Provides standard [[DateTimeFormatter]] instances, as well as methods to create them.
  * @since 0.1.0
  */
trait TimeFormatters {

  /** Provides members providing default ISO-8601 [[DateTimeFormatter]] instances **/
  val Iso: ISO = new ISO {}


  /** Formats or parses an RFC-1123 / RFC822 (internet) date-time **/
  val `RFC1123/RFC822`: DateTimeFormatter = DF.RFC_1123_DATE_TIME

  /** Formats or parses an RFC-1123 / RFC822 (internet) date-time **/
  val Internet: DateTimeFormatter = `RFC1123/RFC822`

  /** Creates a new [[DateTimeFormatter]] based on a string pattern of letters and symbols. See the
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html java API documentation]] for
    * a full list of symbols and meanings. For example, d MMM uuuu will format 2014-06-07 as '7 Jun 2014'.
    *
    * @param pattern  the pattern to use
    * @throws IllegalArgumentException - if the pattern is invalid
    * @return a [[DateTimeFormatter]] based on the pattern
    */
  def apply(pattern: String): DateTimeFormatter = DF.ofPattern(pattern)

  /** Creates a new [[DateTimeFormatter]] based on a string pattern of letters and symbols and the provided locale.
    * This can be changed using `withLocale(Locale)` on the returned formatter. See the
    * [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html java API documentation]] for
    * a full list of symbols and meanings. For example, d MMM uuuu will format 2014-06-07 as '7 Jun 2014'.
    *
    * @param pattern  the pattern to use
    * @param locale the locale to use
    * @return a [[DateTimeFormatter]] based on the pattern and locale
    */
  def apply(pattern: String, locale: Locale): DateTimeFormatter = DF.ofPattern(pattern, locale)


  protected trait ISO {

    /** Formats or parses a date without an offset, such as '20111203'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#BASIC_ISO_DATE Java API]]
      * for more information.
      */
    val Basic: DateTimeFormatter = DF.BASIC_ISO_DATE

    /** Formats or parses a date with the offset if available, such as '2011-12-03' or '2011-12-03+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_DATE Java API]]
      * for more information.
      */
    val Date: DateTimeFormatter = DF.ISO_DATE

    /** Formats or parses a time, with the offset if available, such as '10:15', '10:15:30' or '10:15:30+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_TIME Java API]]
      * for more information.
      */
    val Time: DateTimeFormatter = DF.ISO_TIME

    /** Formats or parses an instant in UTC, such as '2011-12-03T10:15:30Z'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_INSTANT Java API]]
      * for more information.
      */
    val Instant: DateTimeFormatter = DF.ISO_INSTANT

    /** Formats or parses a date without an offset, such as '2011-12-03'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE Java API]]
      * for more information.
      */
    val LocalDate: DateTimeFormatter = DF.ISO_LOCAL_DATE

    /** Formats or parses a date-time without an offset, such as '2011-12-03T10:15:30'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_DATE_TIME Java API]]
      * for more information.
      */
    val LocalDateTime: DateTimeFormatter = DF.ISO_LOCAL_DATE_TIME

    /** Formats or parses a time without an offset, such as '10:15' or '10:15:30'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_LOCAL_TIME Java API]]
      * for more information.
      */
    val LocalTime: DateTimeFormatter = DF.ISO_LOCAL_TIME

    /** Formats or parses a date with an offset, such as '2011-12-03+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_DATE Java API]]
      * for more information.
      */
    val OffsetDate: DateTimeFormatter = DF.ISO_OFFSET_DATE

    /** Formats or parses a date-time with an offset, such as '2011-12-03T10:15:30+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_DATE_TIME Java API]]
      * for more information.
      */
    val OffsetDateTime: DateTimeFormatter = DF.ISO_OFFSET_DATE_TIME

    /** Formats or parses a time with an offset, such as '10:15+01:00' or '10:15:30+01:00'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_OFFSET_TIME Java API]]
      * for more information.
      */
    val OffsetTime: DateTimeFormatter = DF.ISO_OFFSET_TIME

    /** Formats or parses the ordinal date without an offset, such as '2012-337'.
      * See [[http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_ORDINAL_DATE Java API]]
      * for more information.
      */
    val OrdinalDate: DateTimeFormatter = DF.ISO_ORDINAL_DATE
  }

}

