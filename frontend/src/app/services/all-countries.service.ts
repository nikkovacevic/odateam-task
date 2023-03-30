import { Injectable } from '@angular/core';
import { Country } from '../model/Country';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AllCountriesService {
  private apiUrl = 'http://localhost:8080/api/rates/?query=';

  constructor(private http: HttpClient) {
  }

  getAllCountries(query: string): Observable<Country[]> {
    console.log('Fetching ' + query);
    return this.http.get<Country[]>(this.apiUrl + query);
  }
}
