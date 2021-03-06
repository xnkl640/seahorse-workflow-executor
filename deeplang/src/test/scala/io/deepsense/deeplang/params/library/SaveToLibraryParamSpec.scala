/**
 * Copyright 2015, deepsense.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.deepsense.deeplang.params.library

import spray.json._

import io.deepsense.deeplang.params.AbstractParamSpec

class SaveToLibraryParamSpec extends AbstractParamSpec[String, SaveToLibraryParam] {

  override def className: String = "SaveToLibraryParam"

  override def paramFixture: (SaveToLibraryParam, JsValue) = {
    val description = "Save parameter description"
    val param = SaveToLibraryParam(
      name = "Save parameter name",
      description = Some(description))
    val expectedJson = JsObject(
      "type" -> JsString("saveToLibrary"),
      "name" -> JsString(param.name),
      "description" -> JsString(description),
      "default" -> JsNull,
      "isGriddable" -> JsFalse
    )
    (param, expectedJson)
  }

  override def valueFixture: (String, JsValue) = {
    val value = "output abcdefghij"
    (value, JsString(value))
  }
}
