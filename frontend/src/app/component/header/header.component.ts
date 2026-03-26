import { Component, inject } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { RouterLink } from '@angular/router';
import { AvatarModule } from 'primeng/avatar';
import { AvatarGroupModule } from 'primeng/avatargroup';
import { ThemeService } from '../../services/theme.service';
@Component({
  selector: 'app-header-component',
  imports: [AvatarGroupModule, AvatarModule, ButtonModule, RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {

  private themeService = inject(ThemeService);

  get isDarkMode(): boolean {
    return this.themeService.isDark();
  }

  onDarkMode(): void {
    this.themeService.toggleTheme();
  }
}
