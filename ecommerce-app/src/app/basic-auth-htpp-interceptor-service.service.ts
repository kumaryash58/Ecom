import { Injectable } from '@angular/core';
//import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Observable, of, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHtppInterceptorServiceService implements HttpInterceptor{

  constructor(public router: Router) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
    //   req = req.clone({
    //     setHeaders: {
    //       Authorization: sessionStorage.getItem('token')
    //     }
    //   })
    // }
    // return next.handle(req).pipe(
    //   catchError((error) => {
    //   console.log('error is intercept')
    //   console.error(error);
    //   return throwError(error.message);
    // }
    // ));

    if (req.responseType == 'json') {
			req = req.clone({ responseType: 'text' });

			return next.handle(req).pipe(map(response => {
				if (response instanceof HttpResponse) {
					response = response.clone<any>({ body: JSON.parse(response.body) });
				}

				return response;
			}));
		}

		return next.handle(req);
  }
}
