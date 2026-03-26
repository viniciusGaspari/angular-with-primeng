import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SelectModule } from 'primeng/select';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import { LottieComponent, AnimationOptions } from 'ngx-lottie';
import { RouterOutlet } from '@angular/router';
import { ThemeService } from '../../../services/theme.service';
import { inject } from '@angular/core';

@Component({
  selector: 'app-home-auth',
  imports: [LottieComponent, ButtonModule, PasswordModule, FormsModule, SelectModule, InputGroupModule, InputGroupAddonModule, InputNumberModule, InputTextModule, RouterOutlet],
  templateUrl: './home-auth.component.html',
  styleUrl: './home-auth.component.css',
})
export class HomeAuthComponent implements OnInit {
  options: AnimationOptions = {
    path: '/assets/lotties/login-display.json'
  }

  private themeService = inject(ThemeService);


get isDarkMode(): boolean {
    return this.themeService.isDark();
  }

  onDarkMode(): void {
    this.themeService.toggleTheme();
  }

  ngOnInit(): void {

  }
}
