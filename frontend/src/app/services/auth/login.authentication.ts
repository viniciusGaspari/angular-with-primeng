import { inject, Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class LoginAuthenticationService {

    private baseUrl: string = 'http://localhost:8080/api/auth/login';
    
    private http = inject(HttpClient);

    logIn(credentials:{username: string, password: string}): Observable<string> {
        return this.http.post<string>(`${this.baseUrl}`, credentials);
    }

}