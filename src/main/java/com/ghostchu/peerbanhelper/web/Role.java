package com.ghostchu.peerbanhelper.web;

import io.javalin.security.RouteRole;

public enum Role implements RouteRole {ANYONE, USER_READ, USER_WRITE, P2P_FRIEND, P2P_GUEST, PBH_PLUS}

