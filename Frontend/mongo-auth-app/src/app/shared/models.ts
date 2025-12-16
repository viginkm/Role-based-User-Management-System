export interface Models {
}
//
export interface UserDto { username: string; password?: string; role: 'USER' |'ADMIN'; }  
export interface LoginRequest { username: string; password: string; }
export interface LoginResponse { token: string; }