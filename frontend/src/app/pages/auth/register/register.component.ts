import { Component, inject, OnInit } from '@angular/core';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { InputTextModule } from 'primeng/inputtext';
import { Password } from "primeng/password";
import { FloatLabelModule } from 'primeng/floatlabel';
import { ButtonModule } from 'primeng/button';
import { RouterLink } from '@angular/router';
import { FormGroup, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { MyDialogService } from '../../../services/dialog/my.dialog.service';

@Component({
  selector: 'app-register.component',
  imports: [RouterLink, ButtonModule, ReactiveFormsModule, FloatLabelModule, InputTextModule, InputGroupAddonModule, InputGroupModule, Password],
  templateUrl: './register.component.html',
  styleUrl: '../auth.css',
})
export class RegisterComponent implements OnInit {
  private formBuilder = inject(FormBuilder);
  private myDialogService = inject(MyDialogService);

  formGroup!: FormGroup

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      username: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  }
  onSubmit(): void {
    this.myDialogService.showLoading();
    this.myDialogService.onCloseDialog(); 
  } 
}
