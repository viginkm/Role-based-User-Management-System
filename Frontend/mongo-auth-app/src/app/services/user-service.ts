import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDto } from '../shared/models';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}
   //create(user: UserDto) { return this.http.post(`${environment.API_BASE}/create`, user); }
   create(user: UserDto): Observable<any> {
    return this.http.post(`${environment.API_BASE}/users/create`, user);
  }
  
}
