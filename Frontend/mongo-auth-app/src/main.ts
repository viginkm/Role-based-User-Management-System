import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { importProvidersFrom } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthService } from './app/services/authservice';
import { TokenInterceptor } from './app/interceptors/tokeninterceptor';


bootstrapApplication(App, {
  providers: [
    importProvidersFrom(HttpClientModule),   // Make HttpClient available
    AuthService,                             // Provide AuthService
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true }, // Register interceptor
    provideRouter(routes)                     // Provide routing
  ]
}).catch(err => console.error(err));

//bootstrapApplication(App, appConfig)
  //.catch((err) => console.error(err));

//bootstrapApplication(App, {
 // providers: [
   // importProvidersFrom(HttpClientModule),
  //  AuthService,
 //   { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true }
 // ]
//});


//bootstrapApplication(App, {
  //providers: [provideRouter(routes)]
//});


//bootstrapApplication(App, {
  //providers: [provideRouter(routes)]
//})
//.catch(err => console.error(err));