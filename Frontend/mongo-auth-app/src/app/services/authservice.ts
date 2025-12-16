import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest, LoginResponse } from '../shared/models';
import { map, Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private tokenKey = 'app_token';
  private roleKey = 'app_role';
  constructor(private http: HttpClient) {}

  login(payload: LoginRequest): Observable<void> {
    
    return this.http.post<LoginResponse>(`${environment.API_BASE}/auth/login`, payload).pipe(
      tap(res => this.saveToken(res.token)),
      map(() => {
        const t = this.getToken();
        if (t) {
          try {
            
            const p: any = JSON.parse(atob(t.split('.')[1]));
            
            if (p.role) this.setRole(p.role);
            //alert(p)
          } catch(e) {}
        }
      })
    );
  }

  //logout() {
    // best-effort call to backend logout; returns observable
   // return this.http.post(`${environment.API_BASE}/auth/logout`, {});
  //}
  logout() {
localStorage.removeItem(this.tokenKey); localStorage.removeItem(this.roleKey);
}

  saveToken(token: string) { localStorage.setItem(this.tokenKey, token); }
  getToken(): string | null { return localStorage.getItem(this.tokenKey); }
  //clearStorage() { localStorage.removeItem(this.tokenKey); localStorage.removeItem(this.roleKey); }

  setRole(role: string) { localStorage.setItem(this.roleKey, role); }
  getRole(): string | null { return localStorage.getItem(this.roleKey); }

  isLoggedIn(): boolean {
    const token = this.getToken();
    if (!token) return false;
    try {
      const p: any = JSON.parse(atob(token.split('.')[1]));
      if (p.exp && typeof p.exp === 'number') {
        const expired = (Date.now()/1000) > p.exp;
       // if (expired) { this.clearStorage(); return false; }
      }
    } catch(e) {}
    return true;
  }
}