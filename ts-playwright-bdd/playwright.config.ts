import { defineConfig } from '@playwright/test';
import { defineBddConfig } from 'playwright-bdd';

const testDir = defineBddConfig({
  features: 'features/*.feature',
  steps: 'steps/*.ts',
});

export default defineConfig({
  testDir,
  reporter: 'html',
  use: {
    headless: !!process.env.CI,
    screenshot: 'on',
    trace: 'on',
  },
});
