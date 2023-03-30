import { Component, OnInit } from '@angular/core';
import { Country } from '../../model/Country';
import { AllCountriesService } from '../../services/all-countries.service';

@Component({
  selector: 'app-all-countries',
  templateUrl: './all-countries.component.html',
  styleUrls: ['./all-countries.component.css']
})
export class AllCountriesComponent implements OnInit {
  countries: Country[] = [];

  constructor(private allCountriesService: AllCountriesService) {
  }

  ngOnInit(): void {
    this.allCountriesService
      .getAllCountries('ALL')
      .subscribe((allCountries) => this.countries = allCountries);
  }

}
