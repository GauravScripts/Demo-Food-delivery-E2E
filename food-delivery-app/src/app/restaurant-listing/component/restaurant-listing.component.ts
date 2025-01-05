import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {CommonModule, NgForOf} from '@angular/common';
import { RestaurantListingService } from '../service/restaurant-listing.service';
import { Restaurant } from '../../Shared/models/Restaurant';

@Component({
  selector: 'app-restaurant-listing',
  standalone: true,  // Add this
  imports: [
    CommonModule,
    NgForOf
  ],
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.scss',
  providers: [RestaurantListingService]  // Add this if using standalone
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
    const imageCount = 8; // Adjust this number based on the number of images in your asset folder
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.jpg`; // Replace with your image filename pattern
  }

  onButtonClick(id: number | undefined) {
    this.router.navigate(['/food-catalogue', id]);
  }
}
