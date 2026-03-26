import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { providePrimeNG } from 'primeng/config';
import Aura from '@primeng/themes/aura';
import { provideLottieOptions } from 'ngx-lottie';
import { routes } from './app.routes';
import player from 'lottie-web';
import { provideHttpClient, withXsrfConfiguration, withInterceptors, withInterceptorsFromDi } from '@angular/common/http';
import { authInterceptor } from './services/auth/auth.interceptor';
import { MyDialogService } from './services/dialog/my.dialog.service';
import { DialogService } from 'primeng/dynamicdialog';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    provideLottieOptions({
      player: () => player,
    }),
    providePrimeNG({
      theme: {
        preset: Aura,
        options: {
          darkModeSelector: '.my-app-dark',
          ripple: true
        }
      }
    }),
    DialogService,
    provideHttpClient(
      withInterceptors([authInterceptor]),
      withInterceptorsFromDi(),
      withXsrfConfiguration({
        cookieName: 'XSRF-TOKEN',
        headerName: 'X-XSRF-TOKEN'
      })
    )
  ]
};
