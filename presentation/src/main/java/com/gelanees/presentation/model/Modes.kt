package com.gelanees.presentation.model

import com.gelanees.presentation.R

enum class Modes(val id: String, val desc : String, val icon: Int){
       BLACK_CAB_AS_CUSTOMER("black-cab-as-customer","Black Cab as Customer", R.drawable.ic_taxi_24),
       BLACK_CAB_AS_DRIVER("black-cab-as-driver","Black Cab as Driver", R.drawable.ic_taxi_24),
       BUS("bus","Bus", R.drawable.ic_bus_24),
       CABLE_CAR("cable-car","Cable Car", R.drawable.ic_cable_car_24),
       COACH("coach","Coach", R.drawable.ic_coach_24),
       CYCLE("cycle","Cycle", R.drawable.ic_cycle_24),
       CYCLE_HIRE("cycle-hire","Cycle Hire", R.drawable.ic_cycle_24),
       DLR("dlr","DLRe", R.drawable.ic_dlr_24),
       ELECTRIC_CAR("electric-car","Electric Car", R.drawable.ic_electric_car_24),
       GOODS_VEHICLE_AS_DRIVER("goods-vehicle-as-driver","Goods Vehicle As Driver", R.drawable.ic_goods_vehicle_24),
       INTERCHANGE_KEEP_SITTING("interchange-keep-sitting","Interchange Keep Sitting", R.drawable.ic_interchange_24),
       INTERCHANGE_SECURE("interchange-secure","Interchange Secure", R.drawable.ic_interchange_24),
       INTERNATIONAL_RAIL("international-rail","International Rail", R.drawable.ic_internation_rail_24),
       MOTORBIKE_SCOOTER("motorbike-scooter","Motorbike Scooter", R.drawable.ic_motorbike_scooter_24),
       NATIONAL_RAIL("national-rail","National Rail", R.drawable.ic_national_rail_24),
       OVERGROUND("overground","Overground", R.drawable.ic_overground_24),
       PLANE("plane","Plane", R.drawable.ic_plane_24),
       PRIVATE_CAR("private-car","Private Card", R.drawable.ic_car_24),
       PRIVATE_COACH_AS_CUSTOMER("private-coach-as-customer","Private Coach as Customer", R.drawable.ic_coach_24),
       PRIVATE_COACH_AS_DRIVER("private-coach-as-driver","Private Coach as Driver", R.drawable.ic_coach_24),
       PRIVATE_HIRE_AS_CUSTOMER("private-hire-as-customer","Private Hire as Customer", R.drawable.ic_car_24),
       PRIVATE_HIRE_AS_DRIVER("private-hire-as-driver","Private Hire as Driver", R.drawable.ic_car_24),
       REPLACEMENT_BUS("replacement-bus","Replacement Bus", R.drawable.ic_replacement_bus_24),
       RIVER_BUS("river-bus","River Bus", R.drawable.ic_river_24),
       RIVER_TOUR("river-tour","River Tour", R.drawable.ic_river_24),
       TAXI("taxi","Taxi", R.drawable.ic_taxi_24),
       TFL_RAIL("tflrail","TFL Rail", R.drawable.ic_internation_rail_24),
       TRAM("tram","Tram", R.drawable.ic_tram_24),
       TUBE("tube","Tube", R.drawable.ic_underground_24),
       WALKING("walking","Walking", R.drawable.ic_walk_24),
       UNKNOWN("unknown","unknown", R.drawable.ic_walk_24);
}