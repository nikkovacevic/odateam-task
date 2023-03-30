import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Country } from '../../model/Country';
import { AllCountriesService } from '../../services/all-countries.service';

@Component({
  selector: 'app-all-countries',
  templateUrl: './all-countries.component.html',
  styleUrls: ['./all-countries.component.css']
})
export class AllCountriesComponent implements OnInit, OnChanges {

  @Input() type: string;
  @Input() title: string;
  countries: Country[] = [];

  constructor(private allCountriesService: AllCountriesService) {
  }

  ngOnInit(): void {
      this.fetchCountries();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['type'] && !changes['type'].firstChange) {
        this.fetchCountries();
    }
  }

  private fetchCountries() {
    this.allCountriesService
      .getAllCountries(this.type)
      .subscribe((allCountries) => this.countries = allCountries)
  }

}
