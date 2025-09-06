# GitHub Actions Workflows

## Pull Request Build Check

The `pr-build-check.yml` workflow automatically runs on every pull request to verify that the Kotlin Multiplatform project builds successfully.

### What it does:

1. **Environment Setup**:
   - Sets up Java 17 (required for the project)
   - Configures Android SDK (required for Android targets)
   - Caches Gradle dependencies for faster builds

2. **Build Verification**:
   - Validates that the project can be built
   - Compiles all Kotlin Multiplatform targets (Android + JVM)
   - Reports any build failures with stack traces

3. **Optimizations**:
   - Uses Gradle caching to speed up subsequent builds
   - Disables Gradle daemon for CI environment
   - Limits worker threads for stable CI performance

### Supported Branches:
- `main`
- `master`

This ensures that all pull requests are verified to build successfully before they can be merged, helping maintain code quality and preventing build failures in the main branch.