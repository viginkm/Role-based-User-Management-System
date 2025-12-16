import { Component, inject, signal } from '@angular/core';
//import { RouterOutlet } from '@angular/router';
import { AdminCreateUser } from './admin/admin-create-user/admin-create-user';
import { Login } from './login/login';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from './services/authservice';
import { TokenInterceptor } from './interceptors/tokeninterceptor';






@Component({
  selector: 'app-root',
  standalone: true,
  //imports: [RouterOutlet,Login],
  //imports: [AdminCreateUser],
 //imports: [RouterOutlet,Login],
 imports: [RouterOutlet,RouterLink,CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('mongo-auth-app');
  auth = inject(AuthService);
  router = inject(Router);
   logout() {
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}

