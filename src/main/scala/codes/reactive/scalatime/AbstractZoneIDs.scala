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


private[scalatime] abstract class AbstractZoneIDs {


  /** The time-zone ID representing EAT (Eastern Africa Time), with an ID of 'Africa/Nairobi'. **/
  val EAT: ZoneID

  /** The time-zone ID representing UTC (Coordinated Universal Time), with an ID of 'Z'. **/
  val UTC: ZoneID

  /** Queries a [[TemporalAccessor]] to obtain its [[ZoneID]] (if available).
    *
    * @param temporal the temporal object to query
    * @throws DateTimeException - if unable to extract a ZoneID
    * @return the [[ZoneID]]
    */
  def from(temporal: TemporalAccessor): Try[ZoneID]

  /** Parses a [[scala.Predef.String]] producing a [[ZoneID]] or [[ZoneOffset]]. A [[ZoneOffset]] is returned
    * if the String is 'Z', or starts with '+' or '-'. The result will always be a valid ID for which ZoneRules
    * can be obtained.
    *
    * @param zoneID  the time-zone ID
    * @throws DateTimeException if the converted zone ID has an invalid format
    * @throws ZoneRulesException if the converted zone region ID cannot be found
    * @return the [[ZoneID]]
    */
  def apply(zoneID: String): ZoneID

  /** Similar to `apply(zoneID: String)`, but allows supplementing the existing [[ZoneID]]s with a [[scala.Predef.Map]] of
    * aliases.
    *
    * @param zoneID the time-zone ID
    * @param aliasMap a map of alias zone IDs (typically abbreviations) to real zone ID
    * @throws DateTimeException if the converted zone ID has an invalid format
    * @throws ZoneRulesException if the converted zone region ID cannot be found
    * @return the [[ZoneID]]
    */
  def apply(zoneID: String, aliasMap: Map[String, String]): ZoneID


  /** Obtains an instance of [[ZoneID]] wrapping an offset.
    * If the prefix is "GMT", "UTC", or "UT" a ZoneId with the prefix and the non-zero offset is returned.
    * If the prefix is empty "" the ZoneOffset is returned.
    *
    * @param prefix the time-zone ID
    * @param offset the offset
    * @throws DateTimeException if the prefix is not one of "GMT", "UTC", or "UT", or ""
    */
  def apply(prefix: String, offset: ZoneOffset): ZoneID

  /** Queries TimeZone.getDefault() to find the current default time-zone and converts it to a ZoneId.
    *
    * @throws DateTimeException if the converted zone ID has an invalid format
    * @throws ZoneRulesException if the converted zone region ID cannot be found
    * @return the current system default time [[ZoneID]]
    */
  def system: ZoneID

  /** Obtains a [[scala.collection.immutable.Set Set]] of the [[scala.Predef.String String]] form of all currently
    * available region based zone IDs.
    *
    * @return the set of all currently available zone ID
    */
  def entries: Set[String]
}
