import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantListingService } from '../service/restaurant-listing.service';
import { Restaurant } from '../../Shared/models/Restaurant';
import {NgForOf, NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.scss',
  imports: [
    NgForOf
  ],
  providers: [RestaurantListingService]
})
export class RestaurantListingComponent implements OnInit {
  constructor(private router: Router, public restaurantService: RestaurantListingService) { }

  ngOnInit() {
    this.restaurantService.fetchAllRestaurants();
  }

  get restaurantList(): Restaurant[] {
    return this.restaurantService.data();
  }

  getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  getRandomImage(): string {
    const imageCount = 8;
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.jpg`;
  }

  onButtonClick(id: number | undefined) {
    this.router.navigate(['/food-catalogue', id]);
  }
}
