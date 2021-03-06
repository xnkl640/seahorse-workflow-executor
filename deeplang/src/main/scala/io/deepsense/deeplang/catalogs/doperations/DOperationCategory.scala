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

package io.deepsense.deeplang.catalogs.doperations

import io.deepsense.commons.models

/**
 * Category of DOperations.
 * It can be subcategory of different DOperationCategory.
 * @param id id of this category
 * @param name display name of this category
 * @param parent super-category of this one, if None this is top-level category
 *
 * TODO use global id class when available
 */
abstract class DOperationCategory(
    val id: DOperationCategory.Id,
    val name: String,
    val parent: Option[DOperationCategory] = None) {

  def this(
    id: DOperationCategory.Id,
    name: String,
    parent: DOperationCategory) = this(id, name, Some(parent))

  /** List of categories on path from this category to some top-level category. */
  private[doperations] def pathToRoot: List[DOperationCategory] = parent match {
    case Some(category) => this :: category.pathToRoot
    case None => List(this)
  }

  /** List of categories on path from some top-level category to this category. */
  private[doperations] def pathFromRoot: List[DOperationCategory] = pathToRoot.reverse
}

object DOperationCategory {
  type Id = models.Id
  val Id = models.Id
}
