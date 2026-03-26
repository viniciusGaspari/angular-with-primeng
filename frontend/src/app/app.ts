import { Component, signal, OnInit, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ThemeService } from './services/theme.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent implements OnInit{
  
  private themeService = inject(ThemeService);

  ngOnInit(): void {
    this.themeService.toggleTheme();
  }
  protected readonly title = signal('frontend');
}
