import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {environment} from '../../../environments/environment';
import {ResponseDTO} from '../models/ResponseDTO';
import {CountryMockDTO} from '../models/CountryMockDTO';
import {CountryPhoneNumberRequestDTO} from '../models/CountryPhoneNumberRequestDTO';
import {CountryPhoneNumberDTO} from '../models/CountryPhoneNumberDTO';

@Injectable({
    providedIn: 'root'
})
export class HttpCallsService {

    constructor(public http: HttpClient) {
    }


    getCountriesMockUp(): Observable<ResponseDTO<CountryMockDTO[]>> {
        return this.http.get<ResponseDTO<CountryMockDTO[]>>(environment.hostUrl + '/Lookups/countries');
    }

    getCountryPhoneNumberDTO(body : any ): Observable<ResponseDTO<CountryPhoneNumberDTO[]>> {
        return this.http.post<ResponseDTO<CountryPhoneNumberDTO[]>>(environment.hostUrl + '/country-phone-number',body);
    }


}
