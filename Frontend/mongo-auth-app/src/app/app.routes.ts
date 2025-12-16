import { Routes } from '@angular/router';
import { Login } from './login/login';
import { AdminCreateUser } from './admin/admin-create-user/admin-create-user';
import { Testcomponent } from './testcomponent/testcomponent';
import { AuthGuard } from './guard/auth-guard';
import { RoleGuard } from './guard/role-guard';

export const routes: Routes = [
  
  { path: 'login', component: Login },
  //{ path: 'admin/createuser', component: AdminCreateUser },
   { path: 'createuser', component: AdminCreateUser , canActivate: [AuthGuard,RoleGuard],data: { role: 'ADMIN' } },
      { path: 'testcomponent', component: Testcomponent },
      { path: '', redirectTo: 'login', pathMatch: 'full' }
  
  //{ path: 'products', component: ProductListComponent, canActivate: [AuthGuard] },
 // { path: 'admin/create-user', component: AdminCreateUser, canActivate: [AuthGuard, RoleGuard], data: { role: 'ADMIN' } },   
];
