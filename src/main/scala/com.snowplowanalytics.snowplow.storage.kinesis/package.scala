 /*
 * Copyright (c) 2015 Snowplow Analytics Ltd.
 * All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache
 * License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at
 * http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 *
 * See the Apache License Version 2.0 for the specific language
 * governing permissions and limitations there under.
 */

package com.snowplowanalytics.snowplow.storage.kinesis

// Scalaz
import scalaz._
import Scalaz._

package object s3 {

  /**
   * Type for a RawRecord
   */
  type RawRecord = Array[Byte]

  /**
   * Validation for a SnowplowRawEvent
   */
  type ValidatedRecord = Validation[FailedRecord, RawRecord]

  /**
   * Currently the same as ValidatedRecord, but could change in the future
   */
  type EmitterInput = Validation[FailedRecord, RawRecord]

  /**
   * Case class to contain a Failed Record:
   * - The list of errors
   * - The original line, Base64 Encoded
   */
  case class FailedRecord(errors: List[String], line: String)
}
