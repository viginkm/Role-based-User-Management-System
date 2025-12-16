import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/authservice';

@Injectable({ providedIn: 'root' })
export class RoleGuard implements CanActivate {
  constructor(private auth: AuthService, private router: Router) {}
  canActivate(route: ActivatedRouteSnapshot): boolean {
    const required = route.data['role'];
    if (!required) return true;
    const role = this.auth.getRole();
    if (role !== required) {
      alert('Not authorized');
      //this.router.navigate(['/createuser']);
      return false;
    }
    return true;
  }
}