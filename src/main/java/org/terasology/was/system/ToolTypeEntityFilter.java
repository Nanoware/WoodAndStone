/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.was.system;

import org.terasology.anotherWorld.util.Filter;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.logic.inventory.ItemComponent;
import org.terasology.world.block.entity.damage.BlockDamageModifierComponent;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
public class ToolTypeEntityFilter implements Filter<EntityRef> {
    private String toolType;

    public ToolTypeEntityFilter(String toolType) {
        this.toolType = toolType;
    }

    @Override
    public boolean accepts(EntityRef item) {
        ItemComponent component = item.getComponent(ItemComponent.class);
        if (component != null) {
            BlockDamageModifierComponent blockDamage = component.damageType.getComponent(BlockDamageModifierComponent.class);
            return blockDamage != null && blockDamage.materialDamageMultiplier.containsKey(toolType);
        }
        return false;
    }
}
