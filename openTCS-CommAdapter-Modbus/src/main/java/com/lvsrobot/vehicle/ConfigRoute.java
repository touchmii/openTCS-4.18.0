/**
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */

package com.lvsrobot.vehicle;

import org.opentcs.data.model.Point;
import org.opentcs.data.model.Triple;
import org.opentcs.data.order.DriveOrder;
import org.opentcs.data.order.Route;

import java.util.ArrayList;
import java.util.List;

public class ConfigRoute {

    private DriveOrder driveorder;

    private Route route;

    private List<Route.Step> steps;

    public int init = 0;

    //    public ConfigRoute() {
//
//    }
    public int convertPoint(String _point_name) {
        if (_point_name.indexOf("Point") == 0 ) {
            return Integer.parseInt(_point_name.replace("Point-", ""));
        } else {
            return Integer.parseInt(_point_name);
        }
    }

    public void setRoute(DriveOrder dv) {
        driveorder = dv;
        route = driveorder.getRoute();
        steps = route.getSteps();
        init = 1;
    }
    public int[] getPath(Triple current_point) {
        int[] path = new int[steps.size()*4+7];
        switch (driveorder.getDestination().getOperation()) {
            case "MOVE":
                path[1] = 0;
                break;
            case "LOAD":
                path[1] = 1;
//                path[path.length-5] = path[path.length-1];
                break;
            case "UNLOAD":
                path[1] = 2;
                break;
            case "CHARGING":
                path[1] = 3;
                break;
            default:
                break;
        }
        path[2] = steps.size()+1;
        path[3] = convertPoint(steps.get(0).getSourcePoint().getName());
//        String point_name = steps.get(0).getSourcePoint().getName();

        path[4] = (int)steps.get(0).getSourcePoint().getPosition().getX()/10;
        path[5] = (int)steps.get(0).getSourcePoint().getPosition().getY()/10;
        path[6] = 365;
        for(int i = 0; i < steps.size(); i++) {
            Route.Step point = steps.get(i);
//            path[i*4+7] = Integer.parseInt(new String(point.getDestinationPoint().getName()));
            path[i*4+7] = convertPoint(point.getDestinationPoint().getName());
            path[i*4+8] = (int)point.getDestinationPoint().getPosition().getX()/10;
            path[i*4+9] = (int)point.getDestinationPoint().getPosition().getY()/10;
            path[i*4+10] = 365;
            if (path[1] != 0 && i == (steps.size()-1)) {
                path[i * 4 + 10] = (int)point.getDestinationPoint().getVehicleOrientationAngle();
            }
        }

        switch (path[1]) {
            case 1:
                path[path.length-5] = path[path.length-1];
                break;
            case 2:
                path[path.length-5] = path[path.length-1];
                break;
            case 3:
                path[path.length-5] = path[path.length-1];
                break;
        }

        return path;
    }
//    public
}
