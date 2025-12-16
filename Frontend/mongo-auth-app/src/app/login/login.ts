import { Component } from '@angular/core';
import { LoginRequest } from '../shared/models';
import { Router } from '@angular/router';
import { AuthService } from '../services/authservice';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
   //standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  model = { username: '', password: '' };
  loading = false;
  constructor(private auth: AuthService, private router: Router) {}
  submit() {
    this.loading = true;
    this.auth.login(this.model).subscribe({
     // next: () => { this.loading = false; this.router.navigate(['/products']); },
      next: () => { this.loading = false; this.router.navigate(['/createuser']); },
      error: () => { this.loading = false; alert('Invalid credentials'); }
    });
  }

}
