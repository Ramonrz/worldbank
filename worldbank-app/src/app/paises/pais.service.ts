import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ResponsePais } from './responsePais';

@Injectable()
export class PaisService {

  baseURL = `${environment.baseURL}/paises`;

  constructor(private http: HttpClient) { }

  consultarPaises(pagina: number): Observable<ResponsePais> {
    return this.http.get<ResponsePais>(`${this.baseURL}?pagina=${pagina}`);
  }

}
