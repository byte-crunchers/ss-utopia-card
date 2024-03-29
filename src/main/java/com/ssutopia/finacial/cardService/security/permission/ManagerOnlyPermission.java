package com.ssutopia.finacial.cardService.security.permission;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
public @interface ManagerOnlyPermission {
}
