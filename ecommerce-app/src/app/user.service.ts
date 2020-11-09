import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';  

import { User } from './user';
import { Observable, throwError, pipe, BehaviorSubject } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  private baseUrl = 'http://localhost:8081/vendors/';  
  private headers = new Headers({'Content-Type': 'application/json'});
 // token: string;
  constructor(private http:HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
   }  
   public get currentUserValue(): User {
    return this.currentUserSubject.value;
}

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }  

//   authenticate(user: { username: string; }): Observable<User> {
    
//     // (    //console.log(JSON.stringify(opts));
//     // userData: Response) => {
//     //       sessionStorage.setItem('username',user.username);
//     //       const headers = new Headers();
//     //       let tokenParse = JSON.parse(token);             
//     //       headers.append('Authorization', `Bearer ${tokenParse}`);
//     //       sessionStorage.setItem('token', tokenParse);
         
          
//     //       return userData;
//     //      }
//     //     return  this.http.post<User>(this.baseUrl+'signin',user);
     
//     // let tokenParse = JSON.parse(this.token) 
//     // return this.http.post<User>(this.baseUrl+'signin',user).pipe(
//     //  map(
//     //   userData => {
//     //     sessionStorage.setItem('username',user.username);
       
//     //     let tokenStr= 'Bearer '+data['token'];
//     //     sessionStorage.setItem('token', tokenStr);
//     //     return userData;
//     //    }
//     //  )
//     // );
//     // return this.http.post<any>(this.baseUrl+'signin',user).pipe(map((response: Response) => {
//     //     // login successful if there's a jwt token in the response
//     //     let token = response.json() && response.json().token;
//     //     if (token) {
//     //         // store username and jwt token in local storage to keep user logged in between page refreshes
//     //         localStorage.setItem('currentUser', JSON.stringify({ username: user.username, token: token }));
//     //         // return true to indicate successful login
//     //         return true;
//     //     } else {
//     //         // return false to indicate failed login
//     //         return false;
//     //     }
//     // }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
// }

  




  authenticate(user): Observable<User> {
    let email = user.username;
    let password = user.password;
    return this.http.post<any>(this.baseUrl+'signin',user).pipe(
     map(user => {
        sessionStorage.setItem('username',user.username);
        let tokenStr= 'Bearer '+user.token;
        sessionStorage.setItem('token', tokenStr);
        return user;
       }
     )
    );
  }
isUserLoggedIn() {
  let user = sessionStorage.getItem('username')
  //console.log(!(user === null))
  return !(user === null)
}
logOut() {
  sessionStorage.removeItem('username')
}

//Front end API's

  getStudentList(): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+'students-list');  
  }  
  
  createUser(user): Observable<User> {  
    console.log("Te---"+user);
    window.alert(user);
    return this.http.post<User>(this.baseUrl+'vendorSignup', user);   // JSON.stringify(user), this.httpOptions)
    // .pipe(
    //   retry(1),
    //   catchError(this.handleError))  
  }  
  
  deleteStudent(id: number): Observable<any> {  
    return this.http.delete(`${this.baseUrl}/delete-student/${id}`, { responseType: 'text' });  
  }  
  
  getStudent(id: number): Observable<Object> {  
    return this.http.get(`${this.baseUrl}/student/${id}`);  
  }  
  
  updateStudent(id: number, value: any): Observable<Object> {  
    return this.http.post(`${this.baseUrl}/update-student/${id}`, value);  
  } 


// Error handling 
handleError(error: { error: { message: string; }; status: any; message: any; }) {
  let errorMessage = '';
  if(error.error instanceof ErrorEvent) {
    // Get client-side error
    errorMessage = error.error.message;
  } else {
    // Get server-side error
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
  }
  window.alert(errorMessage);
  return throwError(errorMessage);
}

}
