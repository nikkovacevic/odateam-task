import { Country } from './Country';

export const MOCKCOUNTRIES: Country[] = [
  {
    'country': 'Austria',
    'standard_rate': 20,
    'reduced_rate': 10,
    'reduced_rate_alt': 13,
    'super_reduced_rate': false,
    'parking_rate': 12
  },
  {
    'country': 'Belgium',
    'standard_rate': 21,
    'reduced_rate': 12,
    'reduced_rate_alt': 6,
    'super_reduced_rate': false,
    'parking_rate': 12
  },
  {
    'country': 'Bulgaria',
    'standard_rate': 20,
    'reduced_rate': 9,
    'reduced_rate_alt': false,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'Cyprus',
    'standard_rate': 19,
    'reduced_rate': 9,
    'reduced_rate_alt': 5,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'Czech Republic',
    'standard_rate': 21,
    'reduced_rate': 15,
    'reduced_rate_alt': 10,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'Denmark',
    'standard_rate': 25,
    'reduced_rate': false,
    'reduced_rate_alt': false,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'Germany',
    'standard_rate': 19,
    'reduced_rate': 7,
    'reduced_rate_alt': false,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'Estonia',
    'standard_rate': 20,
    'reduced_rate': 9,
    'reduced_rate_alt': false,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    '_comment': 'While the EU uses the country code \'EL\' for Greece, ISO uses \'GR\' - both are included for convenience.',
    'iso_duplicate': 'GR',
    'country': 'Greece',
    'standard_rate': 24,
    'reduced_rate': 13,
    'reduced_rate_alt': 6,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    '_comment': 'Duplicate of EL for convenience; the EU uses the country code \'EL\' for Greece, while ISO uses \'GR\'.',
    'iso_duplicate_of': 'EL',
    'country': 'Greece',
    'standard_rate': 24,
    'reduced_rate': 13,
    'reduced_rate_alt': 6,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'Spain',
    'standard_rate': 21,
    'reduced_rate': 10,
    'reduced_rate_alt': false,
    'super_reduced_rate': 4,
    'parking_rate': false
  },
  {
    'country': 'Finland',
    'standard_rate': 24,
    'reduced_rate': 14,
    'reduced_rate_alt': 10,
    'super_reduced_rate': false,
    'parking_rate': false
  },
  {
    'country': 'France',
    'standard_rate': 20,
    'reduced_rate': 10,
    'reduced_rate_alt': 5.5,
    'super_reduced_rate': 2.1,
    'parking_rate': false
  },
];

