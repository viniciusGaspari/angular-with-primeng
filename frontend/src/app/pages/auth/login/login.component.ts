import { Component, inject, OnInit } from '@angular/core';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { InputTextModule } from 'primeng/inputtext';
import { Password } from "primeng/password";
import { FloatLabelModule } from 'primeng/floatlabel';
import { ButtonModule } from 'primeng/button';
import { RouterLink } from '@angular/router';
import { FormGroup, FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { LoginAuthenticationService } from '../../../services/auth/login.authentication';

@Component({
  selector: 'app-login.component',
  imports: [RouterLink, ButtonModule, ReactiveFormsModule, FloatLabelModule, InputTextModule, InputGroupAddonModule, InputGroupModule, Password],
  templateUrl: './login.component.html',
  styleUrl: '../auth.css',
})
export class LoginComponent implements OnInit {

  private formBuilder = inject(FormBuilder);
  private loginAuthenticationService = inject(LoginAuthenticationService);

  formGroup!: FormGroup

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    })
  }

  onSubmit(): void{
    this.loginAuthenticationService
      .logIn({username: this.formGroup.value.email, password: this.formGroup.value.password})
      .subscribe({
        next: () => {
          console.log(`Deu certo`)
        }
      })
  }

}
