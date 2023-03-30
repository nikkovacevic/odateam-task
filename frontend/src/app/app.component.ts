import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedTab: string = 'all';
  selectedType: string = 'ALL';
  selectedTitle: string = 'List of all the countries and their VAT rates:';


  onTabClick(type: string, title: string) {
    this.selectedType = type;
    this.selectedTitle = title;

    switch (type) {
      case 'ALL':
        this.selectedTab = 'all';
        break;
      case 'HIGHEST':
        this.selectedTab = 'highest';
        break;
      case 'LOWEST':
        this.selectedTab = 'lowest';
        break;
    }
  }
}
