/**
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */

package com.lvsrobot.vehicle;

public interface VelocityListener {

    /**
     * Called when a new velocity value (in mm/s) has been computed.
     *
     * @param velocityValue The new velocity value that has been computed.
     */
    void addVelocityValue(int velocityValue);
}
