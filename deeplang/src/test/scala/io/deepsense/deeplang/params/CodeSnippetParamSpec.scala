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

package io.deepsense.deeplang.params

import spray.json.DefaultJsonProtocol.StringJsonFormat
import spray.json._

class CodeSnippetParamSpec extends AbstractParamSpec[String, CodeSnippetParam] {
  override def className: String = "CodeSnippetParam"

  override def paramFixture: (CodeSnippetParam, JsValue) = {
    val param = CodeSnippetParam(
      "myName", "myDescription", CodeSnippetLanguage(CodeSnippetLanguage.python)
    )
    val js = JsObject(
      "type" -> "codeSnippet".toJson,
      "name" -> param.name.toJson,
      "description" -> param.description.toJson,
      "language" -> JsObject("name" -> "python".toJson),
      "isGriddable" -> JsFalse,
      "default" -> JsNull
    )
    (param, js)
  }

  override def valueFixture: (String, JsValue) = ("some python code", "some python code".toJson)
}
