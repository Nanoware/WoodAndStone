/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.crafting.system;

import org.terasology.crafting.event.CraftInHandButton;
import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.engine.entitySystem.event.ReceiveEvent;
import org.terasology.engine.entitySystem.systems.BaseComponentSystem;
import org.terasology.engine.entitySystem.systems.RegisterMode;
import org.terasology.engine.entitySystem.systems.RegisterSystem;
import org.terasology.engine.network.ClientComponent;
import org.terasology.engine.registry.In;
import org.terasology.engine.rendering.nui.NUIManager;
import org.terasology.input.ButtonState;

/**
 * @author Marcin Sciesinski <marcins78@gmail.com>
 */
@RegisterSystem(RegisterMode.CLIENT)
public class CraftInHandClientSystem extends BaseComponentSystem {
    @In
    private NUIManager nuiManager;
    @In
    private CraftInHandRecipeRegistry recipeRegistry;

    @ReceiveEvent
    public void craftRequested(CraftInHandButton event, EntityRef entity,
                               ClientComponent clientComponent) {
        if (!recipeRegistry.isCraftingInHandDisabled()) {
            if (event.getState() == ButtonState.DOWN) {
                nuiManager.toggleScreen("WoodAndStone:CraftInHand");
            }
        }
    }
}
