import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../services/user-service';
import { UserDto } from '../../shared/models';

@Component({
  selector: 'app-admin-create-user',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './admin-create-user.html',
  styleUrl: './admin-create-user.css',
})
export class AdminCreateUser {
  model: UserDto = { username: '', password: '', role: 'USER' };
constructor(private svc: UserService) {}
  submit() {
    console.log("Submitted:", this.model);
   if (!this.model.username || !this.model.password) { alert('Provide data'); return; }
    this.svc.create(this.model).subscribe({ next: () => { alert('User created'); this.model = { username: '', password: '',role: 'USER' }; }, error: () => alert('Unable to create user') });
  }

}

