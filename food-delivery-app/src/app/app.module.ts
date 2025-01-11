import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {FoodCatalogueComponent} from './food-catalouge/component/food-catalogue.component';
import {RouterOutlet} from '@angular/router';
import {HeaderComponent} from './header/component/header.component';

@NgModule({
  declarations: [
    AppComponent,
    FoodCatalogueComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterOutlet,
    HeaderComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
