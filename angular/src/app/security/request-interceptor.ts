import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {

    constructor(public auth: UserService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const token = this.auth.getToken();
        if (token !== null && token !== '') {
            req = req.clone({
                setHeaders: {
                    Authorization: 'Basic ' + token
                }
            });
        }
        return next.handle(req);
    }

}
