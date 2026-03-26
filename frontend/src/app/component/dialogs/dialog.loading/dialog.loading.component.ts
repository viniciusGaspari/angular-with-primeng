import { Component } from '@angular/core';
import { AnimationOptions, LottieComponent } from 'ngx-lottie';

@Component({
  selector: 'app-dialog.loading.component',
  imports: [LottieComponent],
  templateUrl: './dialog.loading.component.html',
  styleUrl: './dialog.loading.component.css',
})
export class DialogLoadingComponent {
  options: AnimationOptions = {
    path: '/assets/lotties/loading.json'
  }

}
