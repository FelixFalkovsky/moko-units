/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.units.basic.table

import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.units.TableUnitItem

expect class BasicTableUnitItem(
    itemId: Long,
    title: StringDesc,
    subtitle: StringDesc? = null,
    image: ImageResource? = null
) : TableUnitItem
