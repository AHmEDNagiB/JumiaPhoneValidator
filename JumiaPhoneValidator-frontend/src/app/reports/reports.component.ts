import { Component, OnInit } from '@angular/core';
import { HttpCallsService } from '../shared/services/http-calls.service';
import { Observable } from 'rxjs';
import { CountryPhoneNumberDTO } from '../shared/models/CountryPhoneNumberDTO';
import { CountryPhoneNumberRequestDTO } from '../shared/models/CountryPhoneNumberRequestDTO';
import { ResponseDTO } from '../shared/models/ResponseDTO';
import { CountryMockDTO } from '../shared/models/CountryMockDTO';

@Component({
    selector: 'app-reports',
    templateUrl: './reports.component.html',
    styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
    isNoDataFound = false;
    typeSelected = null;
    selectedCountry = null;

    headerRow: string[];
    dataRows: CountryPhoneNumberDTO[];
    countriesMockUp: CountryMockDTO[];



    constructor(public httpCallsService: HttpCallsService) {
    }

    ngOnInit() {
        this.headerRow = ['Phone Number', 'State', 'Country', 'Code'];
        this.getMockUps();
        this.getCountryPhoneNumberList();

    }

    getMockUps() {
        this.httpCallsService.getCountriesMockUp().subscribe(res => {
            this.countriesMockUp = res.data;
        })
    }

    selectType(value: any) {
        console.log(value)
        this.typeSelected = (value != "All") ? value : null;
    }

    filterByType() {
        this.getCountryPhoneNumberList();
    }

    selectCountry(selectedCountry) {
        console.log(selectedCountry)
        this.selectedCountry = (selectedCountry != "All") ? selectedCountry : null;
    }

    getCountryPhoneNumberList() {

        let fun: Observable<ResponseDTO<CountryPhoneNumberDTO[]>>;
        console.log('typeSelected : ' + this.typeSelected)
        fun = this.httpCallsService.getCountryPhoneNumberDTO(this.getBodyParams());

        fun.subscribe(res => {
            this.dataRows = res.data;
            if (this.dataRows.length > 0) {
                this.isNoDataFound = false;
            } else {
                this.isNoDataFound = true;
            }
        }, error => {
            console.log(error);
            this.isNoDataFound = true;
        })
    }

    private getBodyParams() {
        let body = new CountryPhoneNumberRequestDTO();
        body.pageNumber = 0;
        body.pageSize = 40;
        body.countryFilter = this.selectedCountry;
        body.statusFilter = this.typeSelected;
        return body;
    }


}
